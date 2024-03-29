/*
 * JPass
 *
 * Copyright (c) 2009-2020 Gabor Bata
 * All rights reserved.
 *
 */
package xml;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class for conversion between objects and streams representing XMLs.
 *
 * @author Gabor_Bata
 *
 * @param <T> the type of object to map
 */
public class XmlConverter<T> {

    private final Class<T> documentClass;
    private final XmlMapper mapper;

    public XmlConverter(Class<T> documentClass) {
        this.documentClass = documentClass;
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        this.mapper = new XmlMapper(module);
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.mapper.enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION);
    }

    /**
     * Maps the given object to the given output stream.
     *
     * @param document the document object which represents the XML document
     * @param outputStream the output stream
     * @throws IOException if any error occurred
     */
    public void write(T document, OutputStream outputStream) throws IOException {
        mapper.writeValue(outputStream, document);
    }

    /**
     * Maps the given input stream to a document object.
     *
     * @param inputStream the input stream
     * @return the document object
     * @throws IOException if any error occurred
     */
    public T read(InputStream inputStream) throws IOException {
        return mapper.readValue(inputStream, documentClass);
    }
}