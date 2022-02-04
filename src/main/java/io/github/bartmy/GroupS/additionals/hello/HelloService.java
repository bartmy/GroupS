package io.github.bartmy.GroupS.additionals.hello;

import io.github.bartmy.GroupS.additionals.lang.Lang;
import io.github.bartmy.GroupS.additionals.lang.LangRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class HelloService {
    static final  String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1, "Hello","en");

    private LangRepository repository;

    public HelloService(LangRepository repository){
        this.repository = repository;
    }

    public String prepareGreeting(String name, Integer langId){
        langId = Optional.ofNullable(langId).orElse(FALLBACK_LANG.getId());

        var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + "!";
    }
}
