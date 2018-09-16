package com.manoelcampos.soapserver.ws;

import com.manoelcampos.soapserver.dao.DAO;
import com.manoelcampos.soapserver.model.Produto;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Manoel Campos da Silva Filho
 * 
 * @see https://www.developer.com/java/creating-soap-web-services-with-jax-ws.html
 * 
 * @see http://setgetweb.com/p/WAS85x/ae/jaxws.html
 * @see https://blogs.oracle.com/arungupta/totd-124:-using-cdi-jpa-with-jax-rs-and-jax-ws
 * @see https://blogs.oracle.com/arungupta/totd-123:-f:ajax,-bean-validation-for-jsf,-cdi-for-jsf-and-jpa-20-criteria-api-all-in-one-java-ee-6-sample-application
 * @see http://www.universidadejava.com.br/materiais/criando-webservice-com-ejb/
 * @see http://what-when-how.com/enterprise-javabeans-3/developing-ejb-web-services-with-jax-ws-2-0/
 * @see http://tomee.apache.org/examples-trunk/injection-of-entitymanager/
 * @see https://www.javaworld.com/article/2071724/java-web-development/ejb-fundamentals-and-session-beans.html
 */
@WebService(serviceName = "ProdutoWS")
@Stateless
public class ProdutoWS {
    @Inject
    private DAO<Produto> dao;

    @WebMethod(operationName = "adicionar")
    public boolean adicionar(@WebParam(name = "produto") Produto produto) {
        return dao.persist(produto);
    }
    
    @WebMethod(operationName = "getById")
    public Produto getById(@WebParam(name = "id") long id) {
        return dao.getById(id);
    }    
}