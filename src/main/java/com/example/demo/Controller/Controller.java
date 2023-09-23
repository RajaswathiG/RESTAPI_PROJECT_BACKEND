package com.example.demo.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Transaction;
import com.example.demo.Service.Service;


@RestController
@CrossOrigin
public class Controller {
	@Autowired
	Service ss;
	@PostMapping("adddonor")
	public Transaction add(@RequestBody Transaction de)
	{
		return ss.savedonor(de);
	}
	@GetMapping("showdetails")
	public List<Transaction> show()
	{
		return ss.showinfo();
	}
	@GetMapping("showbyid/{donorId}")
	public Optional<Transaction> showid(@PathVariable int donorId)
	{
		return ss.showbyid(donorId);
	}
	@PostMapping("addndonor")
	public List<Transaction> addndetails(@RequestBody List <Transaction> de)
	{
		return ss.savedetails(de);
	}
	@PutMapping("update")
	public Transaction modify(@RequestBody Transaction de)
	{
		return ss.changeinfo(de);
	}
	@PutMapping("updatebyparam")
	public String update(@RequestParam int id, @RequestBody Transaction de) {
		return ss.updateParam(id, de);
	}
	@DeleteMapping("deletedetail")
	public String del(@RequestBody Transaction de)
	{
		ss.deleteinfo(de);
		return "Deleted successfully";
	}
	@DeleteMapping("deletebyid/{id}")
	public String delid (@PathVariable int id)
	{
		ss.deleteid(id);
		return "Deleted Successfully";
	}
	@GetMapping("sortbyname/{firstName}")
	public List<Transaction> getsortinfo(@PathVariable String firstName)
	{
		return ss.sortinfo(firstName);
	}
	@GetMapping("paging/{pageno}/{pagesize}/{lastName}")
	public List<Transaction> showpageinfo(@PathVariable int pageno, @PathVariable int pagesize, @PathVariable String lastName)
	{
		return ss.getbypage(pageno, pagesize, lastName);
	}
	@GetMapping("sortbytrid")
	public List<Transaction> sortbytraid()
	{
		return ss.sbytid();
	}
	@DeleteMapping("qdelbyid/{id}")
	public void del4(@PathVariable int id) {

		ss.qdelbyid(id);
		return ;
	}
	@PutMapping("qupdate6")
	public void updateidbyq()
	{
		ss.updateid6();
		return;
	}
}