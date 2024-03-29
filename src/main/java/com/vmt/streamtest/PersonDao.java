package com.vmt.streamtest;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.queries.CursoredStream;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

//do i really need this annotation?
@Stateless
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

    //https://forum.cuba-platform.com/t/persistence-howto-handle-large-data-sets/3139/5
    public CursoredStream getPersons() {
        try {
            //what does every hint mean and does it affect performance somehow?
            return (CursoredStream) entityManager.createQuery("SELECT b FROM PersonEntity b")
                    .setHint(QueryHints.JDBC_FETCH_SIZE, "100")
                    .setHint(QueryHints.CURSOR, "TRUE")
                    .setHint(QueryHints.CURSOR_INITIAL_SIZE, "100")
                    .setHint(QueryHints.CURSOR_PAGE_SIZE, "100")
                    .setHint(QueryHints.MAINTAIN_CACHE, HintValues.FALSE)
                    .getSingleResult();
            //return getEm().createQuery("SELECT b FROM BookingEntity b")
            //        .setHint("eclipselink.JDBC_FETCH_SIZE", "1")
            //        .setHint("eclipselink.cursor", "TRUE").getResultStream();
        } catch (final IllegalArgumentException | PersistenceException ex) {
            throw new RuntimeException(ex);
        }
    }

}
