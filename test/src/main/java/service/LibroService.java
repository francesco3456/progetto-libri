package service;

import java.util.ArrayList;
import java.util.List;

import model.bean.LibroBean;
import model.dao.Librodao;

public class LibroService {
	
	public List<LibroBean> visualizzaOrdineLibri() {
		
		   Librodao librodao = new Librodao();
		    List<LibroBean> listaLibri = new ArrayList<>();

		    listaLibri = librodao.libriOrdineVista();

		    return listaLibri;
	}
	
	public List<LibroBean> visualizzaAutori() {
		Librodao librodao = new Librodao();
		List<LibroBean> listaLibri = new ArrayList<>();
		
		listaLibri = librodao.selectionAuthor();
		
		return listaLibri;
	}
	
	public List<LibroBean> visualizzaLibriByAutore(String autore) {
		
		Librodao librodao = new Librodao();
		List<LibroBean> listaLibri = new ArrayList<>();
		
		listaLibri = librodao.findByAuthor(autore);
		
		return listaLibri;
	}
	
}
