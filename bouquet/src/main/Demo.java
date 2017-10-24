package main;

import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        int count = 50;
        StringBuilder instances = new StringBuilder();
        FileWriter fileWriter = new FileWriter("out.txt");
        StringBuilder template1 = new StringBuilder();
        StringBuilder template2 = new StringBuilder();
        instances.append("[general]\n" +
                "service_script_postfix = Core\n" +
                "tmp2 = !{{{gen_sprfiles_rule:\n" +
                "     name=Spread_demo0_1,\n" +
                "     osuser=demo0,\n" +
                "     repo=1,\n" +
                "     linkto=main_process,\n" +
                "     src_path_prefix=/demo0,\n" +
                "     dst_path_prefix=/var/www/demo0,\n" +
                "     group_id=3,\n\n" +
                " folders=[\n");
        for (int i = 1; i <= count; i++) {
            String tmp = String.format("%04d", i);

            template1.append(String.format("      {\"path\":\"/sunrise%s/config/etadirect\";\"path_dest\":\"/sunrise%s/config/etadirect\";\"perm\":\"0640\"};\n" +
                                           "      {\"path\":\"/sunrise%s/config/rc.d\";\"path_dest\":\"/sunrise%s/config/rc.d\";\"perm\":\"0640\"}\n", tmp, tmp, tmp, tmp));
            template2.append(String.format("      {\"prefix\":\"/sunrise%s/config\";\"prefix_dest\":\"/sunrise%s/config\";\"perm\":\"0640\";\"ext\":\".*\\\\\\\\.ini\"}\n", tmp, tmp));
        }

        instances.append(template1);
        instances.append(" ],\n\n" +
                " files=[\n");
        instances.append(template2);
        instances.append("],\n" +
                "   namespaces=[\n" +
                "   {\"main\":[{\"0\":\"eta_be_app\"}]}\n" +
                "   ]\n" +
                "}}}!");

        fileWriter.write(instances.toString());
        fileWriter.close();
    }
}
