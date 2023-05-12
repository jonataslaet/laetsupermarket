package com.github.jonataslaet.laetsupermarket;

import com.github.jonataslaet.laetsupermarket.entities.*;
import com.github.jonataslaet.laetsupermarket.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class LaetsupermarketApplication implements CommandLineRunner {

	private final ProductRepository productRepository;

	private final CityRepository cityRepository;

	private final StateRepository stateRepository;

	private final OrderRepository orderRepository;

	private final SaleRepository saleRepository;

	private final AddressRepository addressRepository;

	private final StoreRepository storeRepository;

	private final SupplierRepository supplierRepository;

	private final ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(LaetsupermarketApplication.class, args);
	}

	@Override
	public void run(String... args) {

		State state01 = State.builder().id(null).name("Minas Gerais").build();
		State state02 = State.builder().id(null).name("São Paulo").build();

		City city01 = City.builder().id(null).name("Uberlândia").state(state01).build();
		City city02 = City.builder().id(null).name("São Paulo").state(state02).build();
		City city03 = City.builder().id(null).name("Campinas").state(state02).build();

		state01.getCities().add(city01);
		state02.getCities().addAll(Arrays.asList(city02, city03));

		Address address01 = Address.builder()
				.id(null)
				.name("Rua Flores")
				.number("300")
				.complement("Apto 303")
				.neighborhood("Jardim")
				.zipCode("38220834")
				.city(city01)
				.build();

		Address address02 = Address.builder()
				.id(null)
				.name("Avenida Matos")
				.number("105")
				.complement("Sala 800")
				.neighborhood("Centro")
				.zipCode("38777012")
				.city(city02)
				.build();

		stateRepository.saveAll(Arrays.asList(state01, state02));
		cityRepository.saveAll(Arrays.asList(city01, city02, city03));
		addressRepository.saveAll(Arrays.asList(address01, address02));

		Supplier supplier01 = Supplier.builder()
				.id(null)
				.name("Fornecedor")
				.federalTaxpayerRegistration("91256958000101")
				.build();
		supplier01.getAddresses().add(address01);
		address01.setSupplier(supplier01);
		supplierRepository.save(supplier01);

		Product product01 = Product.builder().id(null).name("Notebook").description("Vostro 3520").unitPrice(new BigDecimal("4500.00")).build();
		Product product02 = Product.builder().id(null).name("Impressora").description("Epson").unitPrice(new BigDecimal("800.00")).build();
		Product product03 = Product.builder().id(null).name("Mouse").description("Nice").unitPrice(new BigDecimal("80.00")).build();
		product01.setSupplier(supplier01);
		product02.setSupplier(supplier01);
		product03.setSupplier(supplier01);
		productRepository.saveAll(List.of(product01, product02, product03));

		Store store01 = Store.builder()
				.name("Marko Informática")
				.description("Loja de Informática")
				.federalTaxpayerRegistration("28035559000176")
				.address(address02)
				.build();
		address02.setStore(store01);
		store01.setAddress(address02);
		storeRepository.save(store01);

		Client cli1 = Client.builder().id(null).name("Jonatas Laet").individualTaxpayerRegistration("05510256389").build();
		clientRepository.save(cli1);

		Order order1 = Order.builder().id(null).build();
		order1.setStore(store01);
		order1.setClient(cli1);
		store01.getOrders().add(order1);

		Order order2 = Order.builder().id(null).build();
		order2.setStore(store01);
		order2.setClient(cli1);
		store01.getOrders().add(order2);

		cli1.getOrders().addAll(Arrays.asList(order1, order2));
		orderRepository.saveAll(List.of(order1, order2));

		Sale sale01 = Sale.builder().amount(1).discount(new BigDecimal("00.00")).build();
		sale01.setOrder(order1);
		sale01.setProduct(product01);

		Sale sale02 = Sale.builder().amount(1).discount(new BigDecimal("00.00")).build();
		sale02.setOrder(order1);
		sale02.setProduct(product01);

		Sale sale03 = Sale.builder().amount(2).discount(new BigDecimal("100.00")).build();
		sale03.setOrder(order2);
		sale03.setProduct(product02);

		order1.getSales().addAll(Arrays.asList(sale01, sale02));
		order2.getSales().add(sale03);
		product01.getSales().add(sale01);
		product02.getSales().add(sale03);
		product03.getSales().add(sale02);
		saleRepository.saveAll(Arrays.asList(sale01, sale02, sale03));

	}
}
