package com.karshu.snippet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 叶勤勇(卡虚)
 * @date 2019/12/02
 **/
public class HttpSnippet {
	/**
	 * 导出Excel
	 * @param response
	 * @throws IOException
	 */
	public static final void exportExcel(HttpServletResponse response) throws IOException {
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=demo.xls");
		OutputStream out = response.getOutputStream();
		// 向out中写入Excel文件内容
		response.flushBuffer();
	}
}
