package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IClienteDAO;
import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	public  IClienteDAO clientedao;
	
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clientedao.findAll();
	}
	
}
