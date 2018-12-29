package sessions_compare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CompareSessions {
    // Input
    private static final String QC_SESSIONS_LIST = "src/main/resources/qc_sessions.list";
    private static final String PROD_SESSIONS_LIST = "src/main/resources/prod_sessions.list";
    // Output
    private static final String EXTRA_QC_SESSIONS_LIST = "src/main/resources/extra_qc_sessions.list";
    private static final String EXTRA_PROD_SESSIONS_LIST = "src/main/resources/extra_prod_sessions.list";

    public static void main(String[] args) throws IOException {
        List<String> qcSessions = Files.readAllLines(Paths.get(QC_SESSIONS_LIST));
        List<String> prodSessions = Files.readAllLines(Paths.get(PROD_SESSIONS_LIST));

        List<String> extraQcSessions = new ArrayList<>(qcSessions);
        extraQcSessions.removeAll(prodSessions);
        Files.write(Paths.get(EXTRA_QC_SESSIONS_LIST), extraQcSessions);

        List<String> extraProdSessions = new ArrayList<>(prodSessions);
        extraProdSessions.removeAll(qcSessions);
        Files.write(Paths.get(EXTRA_PROD_SESSIONS_LIST), extraProdSessions);
    }
}
