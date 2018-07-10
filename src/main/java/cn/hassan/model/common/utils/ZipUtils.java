package cn.hassan.model.common.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.*;

/**
 * 
 * @Description :  字符串压缩工具类
 * @author sam    
 * @version 1.0  
 * @created Apr 19, 2013 4:27:18 PM
 * @fileName com.weqia.common.util.ZipUtils.java
 *
 */
public class ZipUtils {

	/**
	 * 使用gzip进行压缩
	 */
	public static String gzip(String primStr) {
		if (primStr == null || primStr.length() == 0) {
			return primStr;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = null;
		try {
			gzip = new GZIPOutputStream(out);
			gzip.write(primStr.getBytes("utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzip != null) {
				try {
					gzip.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return Base64Util.encode(out.toByteArray());
	}

	/**
	 * 
	 * <p>
	 * Description:使用gzip进行解压缩
	 * </p>
	 * 
	 * @param compressedStr
	 * @return
	 */
	public static String gunzip(String compressedStr) {
		if (compressedStr == null) {
			return null;
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = null;
		GZIPInputStream ginzip = null;
		byte[] compressed = null;
		String decompressed = null;
		try {
			compressed = Base64Util.decode(compressedStr);
			in = new ByteArrayInputStream(compressed);
			ginzip = new GZIPInputStream(in);

			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = ginzip.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			decompressed = out.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ginzip != null) {
				try {
					ginzip.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}

		return decompressed;
	}

	/**
	 * 使用zip进行压缩
	 * 
	 * @param str
	 *            压缩前的文本
	 * @return 返回压缩后的文本
	 */
	public static final String zip(String str) {
		if (str == null)
			return null;
		byte[] compressed;
		ByteArrayOutputStream out = null;
		ZipOutputStream zout = null;
		String compressedStr = null;
		try {
			out = new ByteArrayOutputStream();
			zout = new ZipOutputStream(out);
			zout.putNextEntry(new ZipEntry("0"));
			zout.write(str.getBytes("utf-8"));
			zout.closeEntry();
			compressed = out.toByteArray();
			compressedStr = Base64Util.encode(compressed);
		} catch (IOException e) {
			compressed = null;
		} finally {
			if (zout != null) {
				try {
					zout.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return compressedStr;
	}

	/**
	 * 使用zip进行解压缩
	 * 
	 * @param compressedStr
	 *            压缩后的文本
	 * @return 解压后的字符串
	 */
	public static final String unzip(String compressedStr) {
		if (compressedStr == null) {
			return null;
		}
		ByteArrayOutputStream out = null;
		ByteArrayInputStream in = null;
		ZipInputStream zin = null;
		String decompressed = null;
		try {
			byte[] compressed = Base64Util.decode(compressedStr);
			out = new ByteArrayOutputStream();
			in = new ByteArrayInputStream(compressed);
			zin = new ZipInputStream(in);
			zin.getNextEntry();
			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = zin.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			decompressed = out.toString();
		} catch (IOException e) {
			decompressed = null;
		} finally {
			if (zin != null) {
				try {
					zin.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return decompressed;
	}

	/**
	 * 文件压缩工具类
	 * @param srcFile 目录或者单个文件位置
	 * @param zipFile 压缩后的ZIP文件位置
	 * @throws IOException
	 */
	public static void doCompress(String srcFile, String zipFile) throws IOException {
		doCompress(new File(srcFile), new File(zipFile));
	}

	/**
	 * 文件压缩
	 * @param srcFile 目录或者单个文件
	 * @param zipFile 压缩后的ZIP文件
	 */
	public static void doCompress(File srcFile, File zipFile) throws IOException {
		ZipOutputStream out = null;
		try {
			out = new ZipOutputStream(new FileOutputStream(zipFile));
			doCompress(srcFile, out);
		} catch (Exception e) {
			throw e;
		} finally {
			out.close();
		}
	}

	public static void doCompress(String filelName, ZipOutputStream out) throws IOException {
		doCompress(new File(filelName), out);
	}

	public static void doCompress(File file, ZipOutputStream out) throws IOException {
		doCompress(file, out, "");
	}

	public static void doCompress(File inFile, ZipOutputStream out, String dir) throws IOException {
		if ( inFile.isDirectory() ) {
			File[] files = inFile.listFiles();
			if (files!=null && files.length>0) {
				for (File file : files) {
					String name = inFile.getName();
					if (!"".equals(dir)) {
						name = dir + "/" + name;
					}
					ZipUtils.doCompress(file, out, name);
				}
			}
		} else {
			ZipUtils.doZip(inFile, out, dir);
		}
	}

	public static void doZip(File inFile, ZipOutputStream out, String dir) throws IOException {
		String entryName = inFile.getName();
		ZipEntry entry = new ZipEntry(entryName);
		out.putNextEntry(entry);

		int len = 0 ;
		byte[] buffer = new byte[1024];
		FileInputStream fis = new FileInputStream(inFile);
		while ((len = fis.read(buffer)) > 0) {
			out.write(buffer, 0, len);
			out.flush();
		}
		out.closeEntry();
		fis.close();
	}

	
	/**
	 * 
	 * @Description 编码问题，参考：http://blog.csdn.net/u014424628/article/details/49429393
	 * @param args
	 * @throws IOException
	 *
	 */
	  public static void main(String[] args) throws IOException {
	         
		  gzip_test1();
		  //zip_test1();	 
		  //String str = "H4sIAAAAAAAAAB3IPQ6DMAxA4dt4tuMYWDwxdesVyI9RBkKlpENvUolbdOuBuEdR9ZZPL+6159r1/H7O9wFbSWo24RV5F2Vc8oB/JRLxgkgETQm2eb8lZWIo7f4M1yn99cgq6KCVtarHJH5KxMaj5UwuBhsYAzoz5gV/7SystXkAAAA=";
		  
		  String str = "H4sIAAAAAAAEAMssqSxItTU0sFArzi8tSk4NAXEDnNUKMvLzUv3ybZ91dj+bs+tp//bnCxrVcv0Sc1Ntny6f/HRCr1pBeYrt0/VtIPHizPQ8W6NkyzRjE2OjZENTQ0PTRMM0MzMLC4NkU4tkc8tU8zQjAGVQUdVqAAAA";
		  //H4sIAAAAAAAAAMssqSxItTU0sFArzi8tSk4NAXEDnNUKMvLzUv3ybZ91dj+bs+tp//bnCxrVcv0Sc1Ntny6f/HRCr1pBeYrt0/VtIPHizPQ8W6NkyzRjE2OjZENTQ0PTRMM0MzMLC4NkU4tkc8tU8zQjAGVQUdVqAAAA

		  
		  System.out.println("系统编码:" + System.getProperty("file.encoding"));
		  
		  System.out.println("字符编码:" + System.getProperty(Charset.defaultCharset().displayName()));

		  String strZip = ZipUtils.gunzip(str);
		  System.out.println(strZip);
	  }   
	
	  
	  private static void gzip_test1(){
	      //测试字符串   
		  String str="itype=108&sourceType=PC&phoneNo=手机号码&mName=姓名&pwd=密码&sign=2c9f3432c15115a1f66880c58c79e7f2";
		  
	      //String str="%5B%7B%22lastUpdateTime%22%3A%222011-10-28+9%3A39%3A41%22%2C%22smsList%22%3A%5B%7B%22liveState%22%3A%221";   
		  //String str="%5B%7B%22lastUpdateTime%22%3A%222011-10-28+9%3A39%3A41%22%2C%22smsList%22%3A%5B%7B%22liveState%22%3A%221我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵";
		  //H4sIAAAAAAAAADXFOw7DIAwA0Nsw+4PBHrhC7oADjpCqJFIjVb19p77lred7z0ZA6XUd69yuhoJS0YAqp/szGuaJXgAcY0i1yDUzu+rUoUKGqffWAf5Teq/jbGaqwiRUXPJeglyZQfoegabsP51ifuh4AAAA
		  //
		  //UEsDBBQACAgIAGNPq0IAAAAAAAAAAAAAAAABAAAAMH2MuwoDIRBF/8Z6ro46FrYpk2+IO7oI7qMIhPx9VkidWx0Oh7vdxnPN9JurCdxsIEzyhEX10jDbY+ifchJjetNfn7NmS9aMY+37/chwEiKCD/b66ZrN+dYMriiBqKCpj6lxZOeKSBUVbxO+UEsHCMM1BplrAAAAmAAAAA==
		  //UEsDBBQACAgIAGNPq0IAAAAAAAAAAAAAAAABAAAAMH2MuwoDIRBF/8Z6ro46FrYpk2+IO7oI7qMIhPx9VkidWx0Oh7vdxnPN9JurCdxsIEzyhEX10jDbY+ifchJjetNfn7NmS9aMY+37/chwEiKCD/b66ZrN+dYMriiBqKCpj6lxZOeKSBUVbxO+UEsHCMM1BplrAAAAmAAAAA==
		  //H4sIAAAAAAAAAGWKOw7CMBAFb+N63/q3LtxSwhkwa0eWbJICCXF7QEqqTDUazbyM+5Jpx9YEb4kJhwn+3czb0NPpGof9JDxUfxmmvz5bzUxsxrr053XNsBIigg8MM7tms701w1WUQFTQ1MfUXHTWFpEqKp4Tvp+t56SYAAAA
		  
		  //mFlag=000000003e916b47013e91700b960003&mOldFlag=000000003e916b47013e916e76b50002&itype=202&loginNo=13867165621&mid=&pwd=14e1b600b1fd579f47433b88e8d85291
		  //pwd=14e1b600b1fd579f47433b88e8d85291&mFlag=000000003e916b47013e91700b960003&mid=&loginNo=13867165621&mOldFlag=000000003e916b47013e916e76b50002&itype=202
		  
	      System.out.println("原长度："+str.length());
	      
	      String strZip = ZipUtils.gzip(str);
	      
	      System.out.println("压缩后："+ZipUtils.gzip(str).length());
	         
	      System.out.println(strZip);
	      
	      System.out.println("解压缩："+ZipUtils.gunzip(strZip));
	  }

	  private static void zip_test1(){
	      //测试字符串   
		  String str="ddd";
		  
	      //String str="%5B%7B%22lastUpdateTime%22%3A%222011-10-28+9%3A39%3A41%22%2C%22smsList%22%3A%5B%7B%22liveState%22%3A%221";   
		  //String str="%5B%7B%22lastUpdateTime%22%3A%222011-10-28+9%3A39%3A41%22%2C%22smsList%22%3A%5B%7B%22liveState%22%3A%221我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵我是一个兵";
	         
	      System.out.println("原长度："+str.length());
	         
	      System.out.println("压缩后："+ZipUtils.zip(str).length());
	         
	      System.out.println("解压缩："+ZipUtils.unzip(ZipUtils.zip(str)));
	  }
}
