package com.example.demo.Service;






import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.example.demo.Model.Transaction;
import com.example.demo.Repository.Repo;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	Repo r;
	public Transaction savedonor(Transaction de)
	{
		return r.save(de);
	}
	public List<Transaction> savedetails(List<Transaction> de)
	{
		return (List<Transaction>)r.saveAll(de);
	}
	public List<Transaction> showinfo()
	{
		return r.findAll();
	}
	public Optional<Transaction> showbyid(int id)
	{
		return r.findById(id);
	}
	public Transaction changeinfo(Transaction de)
	{
		return r.saveAndFlush(de);
	}
	public String updateParam(int id, Transaction de) {
		if(r.existsById(id)){
			r.saveAndFlush(de);
			return "Updated";
		}
		else
			return "Please enter an existing id";
	}
	
	public void deleteinfo(Transaction de)
	{
		r.delete(de);
	}
	public void deleteid(int id)
	{
		r.deleteById(id);
	}
	public List<Transaction> sortinfo(String s)
	{
		return r.findAll(Sort.by(Direction.ASC,s));
	}
	public List<Transaction> getbypage(int pgno,int pgsize, String lastName)
	{
		Page<Transaction> p = r.findAll(PageRequest.of(pgno, pgsize,Sort.by("lastName")));
		return p.getContent();
	}	
	public List<Transaction> sbytid()
	{
		return r.sortbytid();
	}
	public void qdelbyid(int id)
	{
		r.deletemebyid(id);
		return;
	}
	public void updateid6()
	{
		r.updatebyq();
		return;
	}
}