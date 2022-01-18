package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
        /*
            컨트롤러에서 리턴 값으로 문자열을 반환하면 viewResolver가
            `resources:templates/` + {viewName} + `.html`
            형태로 해당 문자열을 viewName에 매핑시켜준다.
            (문자열 반환시 viewName과 매핑 할 경로를 따로 설정해 줄 수 있다.)
         */
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    /*
        ResponseBody 어노테이션이 붙으면 기존의 문자열을 반환했을 때 사용되던
        ViewResolver가 아닌 HttpMessageConverter가 내부 동작하게된다.
        *HttpMessageConverter = 문자나 객체 등 return 타입을 다양하게 처리해주는
        각각의 Converter가 포함된 스프링 인터페이스
     */
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge("29");

        return hello;
    }

    // api test용 정적 클래스 생성
    static class Hello {
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
