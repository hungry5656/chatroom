package com.hungry5656.chatroom.grpc.util;

import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
public class ServerUtil {

    public static URL getDefaultSettingsFile() {
        return ServerRPCServer.class.getResource("defaultSettings.json");
    }

    public static String parseConfig(URL featureFile) {
    }
}
