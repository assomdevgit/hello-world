package python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PythonBuilder {

	public static void main(String[] args) throws IOException {
        // 파이썬 소스 파일에 한글 주석이 있으면 실행이 안됨
        // 출력 결과에 한글이 있으면 깨짐
		
        Path currentPath = Paths.get("");
        String path1 = currentPath.toAbsolutePath().toString();
        
        ProcessBuilder pb = new ProcessBuilder("python", path1 + "/src/python/20230825_book.ipynb");
        Process p = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "utf-8"));

        try {
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
