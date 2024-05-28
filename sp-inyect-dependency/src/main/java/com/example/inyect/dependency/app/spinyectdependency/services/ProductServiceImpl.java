package com.example.inyect.dependency.app.spinyectdependency.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.inyect.dependency.app.spinyectdependency.models.Product;
import com.example.inyect.dependency.app.spinyectdependency.repositories.ProductRepository;

/*
 * El servicio accede a los datos mediante 
 * el repositorio pero además, trabaja con estos datos.
 *  
 * El servicio contiene la lógica de negocio de la aplicación.
 */

@Service
public class ProductServiceImpl implements ProductService{

    //Spring buscara un componente que implemente dicha interfaz y la inyectara
    @Autowired
    //se le indica el componente que implementa la interfaz y el que queremos que se inyecte.
    //@Qualifier("productRepositoryJson") 
    @Qualifier("productRepositoryImpl")
    private ProductRepository repository; //Inyectando una interfaz
    
    @Override
    public List<Product> findAll(){
        return repository.findAll();
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
