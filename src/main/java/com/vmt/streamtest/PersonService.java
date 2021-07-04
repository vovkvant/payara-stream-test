package com.vmt.streamtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.persistence.queries.CursoredStream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

//do i really need this annotation?
@ApplicationScoped
public class PersonService implements StreamingOutput {

    @Inject
    PersonDao personDao;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void write(OutputStream outputStream) throws WebApplicationException {
        Writer writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        //explain the approach
        CursoredStream stream = personDao.getPersons();
        while (stream.hasNext()) {
            PersonEntity personEntity = (PersonEntity) stream.nextElement();
            writeDataInStream(writer, personEntity);
            stream.clear();
        }
    }

    private void writeDataInStream(Writer writer, PersonEntity personEntity) {
        try {
            String json = objectMapper.writeValueAsString(personEntity);
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
