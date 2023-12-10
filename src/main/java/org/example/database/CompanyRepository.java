package org.example.database;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.example.bpp.Auditing;
import org.example.bpp.InjectBean;
import org.example.bpp.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transaction
@Auditing
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyRepository implements CrudRepository<Integer,Company> {

    //@Resource(name = "pool1")
//    @Autowired
    //@Qualifier("pool1")
    private final ConnectionPool pool1;
//    @Autowired
    private final List<ConnectionPool> pools;

    private final Integer poolSize;

    public CompanyRepository(@Qualifier("pool1") ConnectionPool pool1,
                             List<ConnectionPool> pools,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.pool1 = pool1;
        this.pools = pools;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init(){
        System.out.println("init");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method");
    }


//    @Autowired
//    @Qualifier("pool1")
//    public void setPool1(ConnectionPool pool1) {
//        this.pool1 = pool1;
//    }

    //    public CompanyRepository(ConnectionPool connectionPool) {
//        this.connectionPool = connectionPool;
//    }
//
//    public static CompanyRepository of(ConnectionPool connectionPool){
//        return new CompanyRepository(connectionPool);
//    }
}
