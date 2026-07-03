package inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}
		//http://localhost:8080/api/pasteles
}
 // JSON Postman

//{
//		"medida": "mediano",
//		"precio": 380.00,
//		"diasVidaUtil": 6,
//		"nombre": "Pastel de Chocolate Alemán",
//		"fechaFabricacion": "2026-07-03",
//		"codigoBarras": "7501234567890"
//		}