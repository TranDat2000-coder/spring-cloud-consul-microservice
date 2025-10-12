package com.example.accountservice.response.feign;

import java.io.IOException;
import java.io.InputStream;

public abstract class Body {

    public abstract Integer length();

    public abstract boolean isRepeatable();

    public abstract InputStream asInputStream() throws IOException;

    public abstract byte[] asBytes() throws IOException;

    public String asString() throws IOException {
        return new String(asBytes());
    }
}
