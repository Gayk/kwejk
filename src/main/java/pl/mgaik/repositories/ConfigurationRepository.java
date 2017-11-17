package pl.mgaik.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mgaik.models.Gif;

@Configuration
public class ConfigurationRepository {


    @Bean
    public GifRepository gifRepository(CategoryRepository categoryRepository) {
        GifRepository gifRepository = new GifRepository();
        gifRepository.add( new Gif( 1L, "android-explosion", true, categoryRepository.findById( 1 ) ) );
        gifRepository.add( new Gif( 2L, "ben-and-mike", false, categoryRepository.findById( 4 ) ) );
        gifRepository.add( new Gif( 3L, "book-dominos", false, categoryRepository.findById( 4 ) ) );
        gifRepository.add( new Gif( 4L, "compiler-bot", true, categoryRepository.findById( 2 ) ) );
        gifRepository.add( new Gif( 5L, "cowboy-coder", false, categoryRepository.findById( 3 ) ) );
        gifRepository.add( new Gif( 6L, "infinite-andrew", false, categoryRepository.findById( 2 ) ) );
        return gifRepository;
    }


}
