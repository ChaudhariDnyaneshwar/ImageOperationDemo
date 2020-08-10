package Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import Service.Bean;
import Service.Dao;
import Service.ImageDao;

@Controller
public class AppController {

	 @Autowired
   Dao da;
	 @RequestMapping(value="/list")
	public ModelAndView getadd()
	{
		ModelAndView mv=new ModelAndView();
		
		List<Bean> list=da.getList();
		
		mv.addObject("lis",list);
		mv.setViewName("index");
		return mv;
	}
	 
	 
	 

		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public ModelAndView save(@RequestParam("name") String name, @RequestParam("age") Integer age,
				@RequestParam("photo") MultipartFile photo) throws IOException {
  
			 Bean obj=new Bean();
			 obj.setName(name);
			 obj.setAge(age);
			 obj.setPhoto(photo);
			 
			  int a=da.insertRecord(obj);
    // int a=img.inserRecords(name, age, photo);
			ModelAndView mv=new ModelAndView();
			if(a>0)
			{
          mv.addObject("msg","don sucessfully");
			}
			else
			{
				mv.addObject("msg","data insertion failed");
			}
			
          mv.setViewName("home");
          return mv;
		}
	 
		@RequestMapping(value="/getStudentPhoto/{id}")
		public void getStudenImage(@PathVariable("id")int id,HttpServletResponse response) throws SQLException, IOException
		{
			
			response.setContentType("image/jpeg/jpg");
			
			Blob ph=da.getImage(id);
			byte[] byets=ph.getBytes(1,(int)ph.length());
			InputStream inputstream=new ByteArrayInputStream(byets);
			IOUtils.copy(inputstream, response.getOutputStream());
			
		}
		
		@RequestMapping(value="/delet/{id}")
		public ModelAndView delete(@PathVariable("id")int id)
		{
			
			ModelAndView mv=new ModelAndView();
			int a=da.delete(id);
			System.out.println(a+"done");
			mv.setViewName("redirect:/list");
			return mv;
		}
		
}
