package com.willproject.dsfrete;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.willproject.dsfrete.entities.Order;
import com.willproject.dsfrete.services.OrderService;

@SpringBootApplication
public class DsfreteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DsfreteApplication.class, args);
	}
	private OrderService orderService;
	private Order order;
	
	public DsfreteApplication(OrderService orderService, Order order) {
		this.orderService = orderService;
		this.order = order;
		
	}
	@Override
	public void run(String... args) throws Exception {
		
		Order order1 = new Order();
	
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Insira o cod:");
		order1.setCode(sc.nextInt());
		
		System.out.println("Insira o valor basico: ");
		order1.setBasic(sc.nextDouble());
		
		System.out.println("Insira a porcentagem do desconto: ");
		order1.setDiscount(sc.nextDouble());
		
		
		System.out.println("O valor total é: "+ orderService.total(order1) );
		sc.close();
		
		
		
	}
}
