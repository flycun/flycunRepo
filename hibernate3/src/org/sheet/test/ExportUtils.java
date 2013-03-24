package org.sheet.test;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;

public class ExportUtils
{
	private static Logger logger = Logger.getLogger(ExportUtils.class);

	public static final String LABEL_CELL = "label";
	public static final String NUMBER_CELL = "number";
	public static final String DATETIME_CELL = "datetime";

	/**
	 * 创建Excel工作表
	 * 
	 * @param out
	 *            输出流
	 * @return
	 */
	public static WritableWorkbook createWorkBook(OutputStream out)
	{
		WritableWorkbook workbook = null;
		try
		{
			workbook = Workbook.createWorkbook(out);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return workbook;
	}

	/**
	 * 在当前工作簿中添加一个Label型的单元格
	 * 
	 * @param sheet
	 *            当前工作簿
	 * @param column
	 *            列号
	 * @param row
	 *            行号
	 * @param value
	 *            值
	 */
	public static void addLabelCell(final WritableSheet sheet, int column,
			int row, Object value)
	{
		try
		{
			String str = "";
			if (value != null)
				str = value.toString();
			Label label = new Label(column, row, str);
			sheet.addCell(label);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 在当前工作簿中添加一个Number型的单元格
	 * 
	 * @param sheet
	 *            当前工作簿
	 * @param column
	 *            列号
	 * @param row
	 *            行号
	 * @param type
	 *            类型
	 * @param value
	 *            值
	 */
	public static void addNumberCell(final WritableSheet sheet, int column,
			int row, Class type, Object value)
	{
		String typeName = type.getSimpleName();
		try
		{
			Number number = null;
			Double val = 0.0;
			if (value != null)
			{
				val = Double.parseDouble(value.toString());
				// 如果是Long或者是Integer类型
				if (typeName.equalsIgnoreCase("Long")
						|| typeName.equalsIgnoreCase("Integer"))
				{
					WritableCellFormat integerFormat = new WritableCellFormat(
							NumberFormats.INTEGER);
					number = new Number(column, row, val, integerFormat);

				}
				// 如果是Double或者是Float类型
				else
				{
					WritableCellFormat floatFormat = new WritableCellFormat(
							NumberFormats.FLOAT);
					number = new Number(column, row, val, floatFormat);
				}
				sheet.addCell(number);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 在当前工作簿中添加一个Date型的单元格
	 * 
	 * @param sheet
	 *            当前工作簿
	 * @param column
	 *            列号
	 * @param row
	 *            行号
	 * @param typeName
	 *            类型名
	 * @param value
	 *            值
	 */
	public static void addDateTimeCell(final WritableSheet sheet, int column,
			int row, Object value)
	{
		try
		{
			DateFormat customDateFormat =  new DateFormat("yyyy-MM-dd hh:mm:ss");

			Date date = stringToDate(value.toString());
			WritableCellFormat dateFormat = new WritableCellFormat(
					customDateFormat);
			if (value != null)
			{
				DateTime dateCell = new DateTime(column, row, date, dateFormat);
				sheet.addCell(dateCell);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * 根据类型获取对应的Excel单元格类型
	 * 
	 * @param type
	 *            类型
	 * @return
	 * @throws Exception
	 */
	public static String getMatchedCellType(Class type) throws Exception
	{
		String cellType = "";
		// 如果是日期型
		if (type.equals(java.util.Date.class))
		{
			cellType = DATETIME_CELL;
		}
		// 如果数字类型
		else if (type.equals(Long.class) || type.equals(Long.TYPE)
				|| type.equals(Integer.class) || type.equals(Integer.TYPE)
				|| type.equals(Double.class) || type.equals(Double.TYPE)
				|| type.equals("Float") || type.equals(Float.TYPE))
		{

			cellType = NUMBER_CELL;
		}
		// 如果是文字型
		else if (type.equals(String.class))
		{
			cellType = LABEL_CELL;
		} else
		{
			throw new Exception("Could not find mathched cell type:"
					+ type.getName());
		}
		return cellType;
	}

	/**
	 * 根据数据的类型在当前工作簿中添加一个单元格
	 * 
	 * @param sheet
	 *            当前工作簿
	 * @param column
	 *            列号
	 * @param row
	 *            行号
	 * @param typeName
	 *            类型名
	 * @param value
	 *            值
	 */
	public static void addCellByType(WritableSheet sheet, int column, int row,
			Class type, Object value)
	{
		try
		{
			if (getMatchedCellType(type).equals(LABEL_CELL))
			{
				addLabelCell(sheet, column, row, value);
			} else if (getMatchedCellType(type).equals(NUMBER_CELL))
			{
				addNumberCell(sheet, column, row, type, value);
			} else
			{
				addDateTimeCell(sheet, column, row, value);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void setColumnWidth(final WritableSheet sheet, int column,
			String header)
	{
		int width = header.length() * 2;
		sheet.setColumnView(column, width);
	}

	/**
	 * 设置Excel表头
	 * 
	 * @param sheet
	 *            当前工作簿
	 * @param headers
	 *            每一列列名
	 */
	public static void setColumnHeaders(final WritableSheet sheet,
			final List<String> headers)
	{
		for (int i = 0; i < headers.size(); i++)
		{
			addLabelCell(sheet, i, 0, headers.get(i));
			setColumnWidth(sheet, i, headers.get(i));
		}
	}

	/**
	 * 把结果集写入Excel工作簿
	 * 
	 * @param sheet
	 *            当前工作簿
	 * @param resultSet
	 *            结果集
	 * @param properties
	 *            属性列表
	 */
	public static void writeResultSet(final WritableSheet sheet,
			final List resultSet, final List<String> properties)
	{
		if (resultSet != null && resultSet.size() > 0)
		{
			for (int row = 0; row < resultSet.size(); row++)
			{
				Object obj = resultSet.get(row);
				for (int column = 0; column < properties.size(); column++)
				{
					String property = properties.get(column).trim();

					String value = "";
					PropertyDescriptor descriptor = null;
					try
					{

						descriptor = new PropertyDescriptor(property,
								obj.getClass());

						Object objValue = descriptor.getReadMethod()
								.invoke(obj);

						value = objValue != null ? objValue.toString() : "";

					} catch (Exception e)
					{
						e.printStackTrace();
						value = "";
					}
					// 获取属性值的类型
					Class type = descriptor.getPropertyType();
					// 把结果集中某一条记录中的某一个属性的值写入工作簿
					addCellByType(sheet, column, row + 1, type, value);

				}
			}
		}
	}

	/**
	 * 导出Excel
	 * 
	 * @param resultSet
	 *            查询得到的结果集
	 * @param out
	 *            输出流
	 * @param headers
	 *            列名
	 * @param properties
	 *            属性列表
	 */
	public static byte[] exportExcel(List resultSet,
			final List<String> headers, final List<String> properties)
	{

		WritableWorkbook book = null;
		WritableSheet sheet = null;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try
		{
			book = createWorkBook(bos);
			sheet = book.createSheet("导出数据", 0);

			// 设置Excel工作簿中每一列列头名
			setColumnHeaders(sheet, headers);

			// 写入结果集
			writeResultSet(sheet, resultSet, properties);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				book.write();
				book.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return bos.toByteArray();

	}
	public static Date stringToDate(String date) throws Exception 
	{
		java.text.DateFormat df= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		return df.parse(date);
	}
}
