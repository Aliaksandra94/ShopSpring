package project.moroz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import project.moroz.model.Product;
import project.moroz.model.Role;
import project.moroz.repository.DAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductProjectServiceImpl implements ProjectService<Product> {
    private DAO productDAO;

    @Autowired
    public void setProductDAO(@Qualifier("productDAOImpl") DAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    @Transactional
    public List<Product> getList() {
        return productDAO.getList();
    }

    @Override
    @Transactional
    public void add(Product product) {
        productDAO.add(product);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        productDAO.delete(product);
    }

    @Override
    @Transactional
    public void edit(Product product) {
        productDAO.edit(product);
    }

    @Override
    @Transactional
    public Product getById(int id) {
        return (Product) productDAO.getById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        productDAO.save(product);
        return product;
    }
}
