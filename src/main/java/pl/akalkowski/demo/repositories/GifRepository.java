package pl.akalkowski.demo.repositories;

import pl.akalkowski.demo.models.Category;
import pl.akalkowski.demo.models.Gif;

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

    public List<Gif> getFavorites() {
        List<Gif> favorites = new ArrayList<>();
        gifs.stream().forEach( gif -> {
            if (gif.isFavorite()) {
                favorites.add( gif );
            }
        } );
        return favorites;
    }

    public List<Gif> findAll() {
        return gifs;
    }

    public List<Gif> findByName(String name) {
        List<Gif> gifList = new ArrayList<>();
        for (Gif gif : gifs) {
            if (gif.getName().contains( name )) {
                gifList.add( gif );
            }
        }
        return gifList;
    }

//    public List<Gif> getGifsByCategory(Long id) {
//        List<Gif> gifsByCategory = new ArrayList<>();
//        gifs.stream().forEach( gif -> {
//            if (gif.getCategory().getId().equals( id )) {
//                gifsByCategory.add( gif );
//            }
//        } );
//        return gifsByCategory;

    public List<Gif> getGifsByCategoryId(Long categoryId) {
        List<Gif> categoryGif = new ArrayList<>();
        for (Gif gif : gifs) {
            if (gif.getCategory().getId().equals( categoryId )) {
                categoryGif.add( gif );
            }
        }
        return categoryGif;
    }
}