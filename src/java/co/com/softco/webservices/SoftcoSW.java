/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.softco.webservices;

import co.com.softco.model.dao.ModeloTrackerDAO;
import co.com.softco.model.pojos.ModeloTracker;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author david
 */
@WebService(serviceName = "SoftcoSW")
public class SoftcoSW {

    /**
     * Permite realizar la insercion de modelos de tracker
     * @param codModelo Codigo del modelo del tracker
     * @param descModelo Descripcion del modelo del tracker
     */
    @WebMethod(operationName = "IngresarModeloTracker")
    public void IngresarModeloTracker(@WebParam(name = "codModelo") String codModelo, @WebParam(name = "descModelo") String descModelo) throws RuntimeException {
        ModeloTracker m = new ModeloTracker(codModelo, descModelo);
        ModeloTrackerDAO mDao = new ModeloTrackerDAO();
        try{
            mDao.insertarModeloTracker(m);
        }catch(RuntimeException re){
            throw re;
        }
    }
}
