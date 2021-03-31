package com.julianafarias.cursomcjava;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.julianafarias.cursomcjava.domain.Categoria;
import com.julianafarias.cursomcjava.domain.Cidade;
import com.julianafarias.cursomcjava.domain.Cliente;
import com.julianafarias.cursomcjava.domain.Endereco;
import com.julianafarias.cursomcjava.domain.Estado;
import com.julianafarias.cursomcjava.domain.Produto;
import com.julianafarias.cursomcjava.domain.enums.TipoCliente;
import com.julianafarias.cursomcjava.repositories.CategoriaRepository;
import com.julianafarias.cursomcjava.repositories.CidadeRepository;
import com.julianafarias.cursomcjava.repositories.ClienteRepository;
import com.julianafarias.cursomcjava.repositories.EnderecoRepository;
import com.julianafarias.cursomcjava.repositories.EstadoRepository;
import com.julianafarias.cursomcjava.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcjavaApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcjavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		//realizando as associações entre categorias com os produtos
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));		
		cat2.getProdutos().addAll(Arrays.asList(p2));

		//realizando as associações entre os produtos com as categorias
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));		
		
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		
		Cliente cl1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cl1.getTelefones().addAll(Arrays.asList("27362223", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cl1, c1);
		
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "387777012", cl1, c2);
		
		cl1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	
	}

}
