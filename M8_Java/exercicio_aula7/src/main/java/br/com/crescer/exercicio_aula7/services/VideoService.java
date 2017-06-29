/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio_aula7.services;

import br.com.crescer.exercicio_aula7.entities.Genero;
import br.com.crescer.exercicio_aula7.entities.Video;
import br.com.crescer.exercicio_aula7.repos.GeneroRepository;
import br.com.crescer.exercicio_aula7.repos.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    
    @Autowired
    VideoRepository videoRepository;
    
    public void post (Video video) {
        videoRepository.save(video);
    }
    
    public void delete (Long id) {
        videoRepository.delete(id);
    }
    
    public Video loadById (Long id) {
        return videoRepository.findOne(id);
    }
    
    public Iterable<Video> findAll() {
        return videoRepository.findAll();
    }
}
