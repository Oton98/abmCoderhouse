package com.example.demo.controllers;

import com.example.demo.model.Cliente;
import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import com.example.demo.repository.RepositoryCliente;
import com.example.demo.repository.RepositoryProducto;
import com.example.demo.repository.RepositoryVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private RepositoryCliente clienteRepository;

    @Autowired
    private RepositoryProducto productoRepository;

    @Autowired
    private RepositoryVenta ventaRepository;

    //Post de Venta, Cliente y Produdcto

    @PostMapping("altaVenta")
    public  String post(@RequestBody Venta venta){
        ventaRepository.save(venta);
        return "Guardado";
    }

    @PostMapping("altaCliente")
    public String post(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return "Guardado";
    }

    @PostMapping("altaProducto")
    public String post(@RequestBody Producto producto){
        productoRepository.save(producto);
        return "Guardado";
    }

    //Post de Venta, Cliente y Producto
    @GetMapping("ventas")
    public List<Venta> getVentas(){
        return ventaRepository.findAll();
    }

    @GetMapping("clientes")
    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("productos")
    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    //Puts de Cliente y de Producto (no creo que haya de venta)

    @PutMapping("modificarCliente/{id}")
    public String update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente updateCliente = clienteRepository.findById(id).orElse(null);

        if (updateCliente != null) {
            updateCliente.setNombre(cliente.getNombre());
            updateCliente.setApellido(cliente.getApellido());
            updateCliente.setDni(cliente.getDni());
            updateCliente.setCorreo(cliente.getCorreo());
            clienteRepository.save(updateCliente);
            return "modificado";
        } else {
            return "Cliente no encontrado";
        }
    }

    @PutMapping("modificarProducto/{id}")
    public String update(@PathVariable Long id, @RequestBody Producto producto){
        Producto updateProducto = productoRepository.findById(id).orElse(null);
        if (updateProducto != null){
            updateProducto.setModelo(producto.getModelo());
            updateProducto.setCodigo(producto.getCodigo());
            updateProducto.setPeso(producto.getPeso());
            updateProducto.setCantidad(producto.getCantidad());
            updateProducto.setDisponible(producto.isDisponible());
            productoRepository.save(updateProducto);
            return "modificado";
        } else {
            return "Producto no encontrado";
        }
    }

    //Delete de Venta, Productos y Cliente
    @DeleteMapping("borrarVenta/{id}")
    public String deleteVenta(@PathVariable Long id){
        Venta deleteVenta = ventaRepository.findById(id).get();
        ventaRepository.delete(deleteVenta);
        return "Eliminado";
    }

    @DeleteMapping("borrarCliente/{id}")
    public String deleteCliente(@PathVariable Long id){
        Cliente deleteCliente = clienteRepository.findById(id).get();
        clienteRepository.delete(deleteCliente);
        return "Eliminado";
    }

    @DeleteMapping("borrarProducto/{id}")
    public String deleteProducto(@PathVariable Long id){
        Producto deleteProducto = productoRepository.findById(id).get();
        productoRepository.delete(deleteProducto);
        return "Eliminado";
    }
}
