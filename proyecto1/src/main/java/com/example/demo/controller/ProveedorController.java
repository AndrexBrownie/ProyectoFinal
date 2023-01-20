package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Proveedor;
import com.example.demo.service.ProveedorService;

@Controller
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/listado")
	public String listar(Model model) {
	List<Proveedor> lista = proveedorService.listarTodos();
	model.addAttribute("titulo", "LISTA DE PROVEEDORES");
	model.addAttribute("proveedores", lista);
	return "listado";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		Proveedor proveedor = new Proveedor();
		List<Proveedor> listaProveedores = proveedorService.listarTodos();
		model.addAttribute("titulo", "NUEVO PROVEEDOR");
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("proveedores", listaProveedores);
	return "frmEditar";
	}
	
	@PostMapping("/grabar")
	public String guardar(@ModelAttribute Proveedor proveedor) {
		proveedorService.grabar(proveedor);
		System.out.println("Proveedor grabado con exito!");
		return "redirect:http://localhost:8080/listado";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Proveedor proveedor = proveedorService.buscarPorId(id);
		List<Proveedor> listaProveedores = proveedorService.listarTodos();
		model.addAttribute("titulo", "EDITAR PRODUCTO ("+ id +")");
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("proveedores", listaProveedores);
	return "frmEditar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		proveedorService.eliminar(id);
		System.out.println("Proveedor eliminado con exito!");
	return "redirect:http://localhost:8080/listado";
	}
}
