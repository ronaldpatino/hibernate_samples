import com.rpg.model.MensajeModel;
import com.rpg.model.RespuestaModel;
import com.rpg.model.RespuestasModel;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ronaldpatino on 10/19/14.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();

            RespuestaModel respuesta = new RespuestaModel();
            MensajeModel mensaje = new MensajeModel();

            //mensaje.setId(0);
            mensaje.setIdentificador("id");
            mensaje.setInformacionAdicional("informacion adicional");
            mensaje.setMensaje("este es el mensaje");
            mensaje.setTipo("A");
            mensaje.setFecha(df.format(today));

            respuesta.setCodigoDocumentoSri("1");
            respuesta.setCodigoLocal("111");
            respuesta.setCodigoPuntoVenta("111");
            respuesta.setNumeroFactura("000000001");
            respuesta.setClaveAcceso("claveacceso");
            respuesta.setNumeroAutorizacion("numeroauto");
            respuesta.setResultado("El resultado");
            respuesta.setAmbiente("1");
            respuesta.setIdFactura("lafactura");
            respuesta.setFecha(df.format(today));

            //mensaje.setRespuesta(null);
            mensaje.setRespuesta(respuesta);
            respuesta.getMensajes().add(mensaje);


            session.beginTransaction();
            session.save(respuesta);

            session.getTransaction().commit();

            List list = session.createQuery("from RespuestasModel").list();

            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {
                RespuestasModel obj = (RespuestasModel) iterator.next();

                System.out.print(obj.getId() + "\t" + obj.getIdFactura() + "\t" + obj.getFecha() + "\n");
            }
            /*
            System.out.println("querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
            */

        } finally {
            session.close();
        }
    }
}
