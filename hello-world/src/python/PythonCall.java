package python;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

public class PythonCall {

	public static void main(String[] args) throws FileNotFoundException, ScriptException {
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptContext context = new SimpleScriptContext();

        // 출력 방향 설정
//        StringWriter writer = new StringWriter();
//        context.setWriter(writer);
//        ScriptEngine engine = manager.getEngineByName("python");
//        String path = System.getProperty("user.dir");
//        System.out.println("현재 작업 경로: " + path);
//        
//        Path currentPath = Paths.get("");
//        String path1 = currentPath.toAbsolutePath().toString();
//        System.out.println("현재 작업 경로: " + path1);
        
//        engine.eval(new FileReader(path1 + "/src/python/20230825_book.ipynb"), context);
//        System.out.println(writer.toString());
        
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("python");

        if (engine != null) {
            ScriptContext context = engine.getContext();
            // 필요한 경우 변수, 바인딩 또는 다른 컨텍스트 속성을 설정할 수 있습니다
            // ...
            Path currentPath = Paths.get("");
            String path1 = currentPath.toAbsolutePath().toString();
//            String path1 = "/your/path";  // 적절한 경로로 변경해주세요
            String scriptPath = path1 + "/src/python/20230825_book.ipynb";
            engine.eval(new FileReader(scriptPath), context);
        } else {
            System.out.println("스크립트 엔진이 null이거나 사용할 수 없습니다.");
        }
        
    }

}
