package com.howtodoinjava.jersey;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;


//using servlet import
import java.io.PrintWriter;  
import java.util.Iterator;   
import java.util.List;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileItemFactory;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  

@Path("/uploadnew")
public class JerseyServicenew 
{
	@POST
	@Path("/pdfnew")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response uploadPdfFile(  @FormDataParam("file") InputStream fileInputStream,
	                                @FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception
	{	
		
		System.out.print("===============================================================");
	    String UPLOAD_PATH = "H:/Rajesh/uploadedfiles/";
	 
	    
	    try
	    {
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + fileMetaData.getFileName()));
	        while ((read = fileInputStream.read(bytes)) != -1)
	        {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	    } catch (IOException e)
	    {
	        throw new WebApplicationException("Error while uploading file. Please try again !!");
	    }
	    return Response.ok("Data uploaded successfully !!").build();
	}
	
	/*
	@POST
	@Path("/pdfone")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException
	{
		File convertFile = new File("H:\\Rajesh\\uploadedfiles\\" + file.getOriginalFilename());
		convertFile.createNewFile();

		try (FileOutputStream fout = new FileOutputStream(convertFile))
		{
			fout.write(file.getBytes());
		}
		catch (Exception exe)
		{
			exe.printStackTrace();
		}
		return "File has uploaded successfully";
	}
	
	
	
	//using servlet code
	@POST
	@Path("/pdfnewupload")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response doPost(HttpServletRequest request, HttpServletResponse response)  
	          throws ServletException, IOException 
	          {  
	            boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
	            response.setContentType("text/html");  
	            PrintWriter out = response.getWriter();  
	            if (isMultipart) 
	            {  
	                // Create a factory for disk-based file items  
	                FileItemFactory factory = new DiskFileItemFactory();  
	                // Create a new file upload handler  
	                ServletFileUpload upload = new ServletFileUpload(factory);  
	                try 
	                {  
	                    // Parse the request  
	                    List items = upload.parseRequest(request);  
	                    Iterator iterator = items.iterator();  
	                    while (iterator.hasNext()) 
	                    {  
	                        FileItem item = (FileItem) iterator.next();  
	                        if (!item.isFormField())  
	                        {  
	                            String fileName = item.getName();      
	                           // String root = getServletContext().getRealPath("/"); 
	                            String root ="H:/Rajesh/uploadedfiles";
	                            File path = new File(root + "/uploads");  
	                            if (!path.exists())  
	                            {  
	                                boolean status = path.mkdirs();  
	                            }  
	                            File uploadedFile = new File(path + "/" + fileName);  
	                            System.out.println(uploadedFile.getAbsolutePath());  
	                        if(fileName!="")  
	                            item.write(uploadedFile);  
	                        else  
	                        out.println("file not found");  
	                        out.println("<h1>File Uploaded Successfully....:-)</h1>");  
	                    }  
	                    else  
	                    {  
	                        String abc = item.getString();  
	                        out.println("<br><br><h1>"+abc+"</h1><br><br>");  
	                    }  
	                }  
	            } 
	            catch (FileUploadException e) 
	            {  
	            out.println(e);  
	            } 
	            catch (Exception e) 
	            {  
	            out.println(e);  
	            }  
	        }  
	        else  
	        {  
	            out.println("Not Multipart");  
	        }  
	        return Response.ok("Data uploaded successfully !!").build();
	      }
		*/
	
}
