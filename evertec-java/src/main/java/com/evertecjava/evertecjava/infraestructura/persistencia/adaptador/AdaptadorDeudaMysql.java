package com.evertecjava.evertecjava.infraestructura.persistencia.adaptador;

import com.evertecjava.evertecjava.dominio.entidades.Deuda;
import com.evertecjava.evertecjava.dominio.puerto.IPuertoDeuda;
import com.evertecjava.evertecjava.infraestructura.exception.DeudaMysqlExcepcion;
import com.evertecjava.evertecjava.infraestructura.persistencia.entidad.DeudaEntidad;
import com.evertecjava.evertecjava.infraestructura.persistencia.transformador.DeudaTransformador;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository

public class AdaptadorDeudaMysql implements IPuertoDeuda {

    @PersistenceContext
    private EntityManager entityManager;
    private static final String DEUDA_FIND_ALL= "select d from Deuda d";
    public AdaptadorDeudaMysql(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void cargarDeudas(List<Deuda> deudas) {
        try{
            for (Deuda deuda:deudas
            ) {
                DeudaEntidad deudaEntidad= DeudaTransformador.convertirDeudaDominioADeudaEntity(deuda);
                this.entityManager.persist(deudaEntidad);
            }
        }catch (EntityExistsException e){
            throw new DeudaMysqlExcepcion("Existe una  deuda con es identificador en la base de datos");
        }

    }

    @Override
    public List<Deuda> ListarDeudas() {
        Query query=this.entityManager.createQuery(DEUDA_FIND_ALL);

        return DeudaTransformador.convertirListaPagoEntityAListaPagoDominio(query.getResultList());
    }
}
