package io.github.xfournet.jconfig.raw;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import io.github.xfournet.jconfig.FileHandler;

public class RawFileHandler implements FileHandler {
    @Override
    public boolean canHandle(Path file) {
        return true;
    }

    @Override
    public Charset getCharset() {
        return StandardCharsets.UTF_8;
    }

    @Override
    public void mergeFiles(Path source1, Path source2, Path destination) {
        throw new UnsupportedOperationException("Cannot merge raw files");
    }

    @Override
    public void apply(Path file, List<String> instructions, Path destination) {
        throw new UnsupportedOperationException("Cannot apply instructions for raw files");
    }

    @Override
    public void setEntry(Path file, String entry, Path destination) {
        throw new UnsupportedOperationException("Cannot edit entry for raw files");
    }

    @Override
    public void removeEntry(Path file, String entry, Path destination) {
        throw new UnsupportedOperationException("Cannot edit entry for raw files");
    }

    @Override
    public void normalize(Path file, Path destination) {
        copy(file, destination);
    }

    private void copy(Path from, Path to) {
        try {
            Files.createDirectories(to.getParent());
            Files.copy(from, to);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
