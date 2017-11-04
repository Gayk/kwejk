package pl.akalkowski.demo.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import pl.akalkowski.demo.model.Gif;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monik on 04.11.2017.
 */
public class GifRepository {
    List<Gif> gifs = new ArrayList<>();

    public void add(Gif gif) {
        gifs.add( gif );
    }

    List<Gif> favuriteGif() {
        for (Gif gif : gifs) {
            if (gif.isFavorite()) {
                favuriteGif().add( gif );

            }
        }
        return favuriteGif();
    }

    public List<Gif> findAll() {
        return gifs;

    }

}


