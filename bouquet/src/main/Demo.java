package main;

import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("test");
        int count = 50;
        StringBuilder instances = new StringBuilder();
        FileWriter fileWriter = new FileWriter("out.txt");
        String template1 = "";
        String template2 = "";
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
            template1 += "      {\"path\":\"/sunrise" + tmp + "/config/etadirect\";\"path_dest\":\"/sunrise" + tmp + "/config/etadirect\";\"perm\":\"0640\"};\n" +
                    "      {\"path\":\"/sunrise" + tmp + "/config/rc.d\";\"path_dest\":\"/sunrise" + tmp + "/config/rc.d\";\"perm\":\"0640\"}\n";
            template2 += "      {\"prefix\":\"/sunrise" + tmp + "/config\";\"prefix_dest\":\"/sunrise" + tmp + "/config\";\"perm\":\"0640\";\"ext\":\".*\\\\\\\\.ini\"}\n";
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
