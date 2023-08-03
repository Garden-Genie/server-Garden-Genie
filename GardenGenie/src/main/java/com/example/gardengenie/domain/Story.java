package com.example.gardengenie.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "story_id")
    private int story_id;

    @Column(nullable = false)
    private LocalDateTime story_date;

//    @Column(length = 30, nullable = false, name = "plt_name")
//    private String plt_name;

    @Column(nullable = true, name = "story_explain", columnDefinition = "TEXT")
    private String story_explain;

    @Column(length = 100, nullable = true, name = "story_music")
    private String story_music;

    @Column(nullable = true, name = "story_poem", columnDefinition = "TEXT")
    private String story_poem;

    @Column(length = 30, nullable = true, name = "story_condition")
    private String story_condition;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
//    private User user;

    @OneToOne
    @JoinColumn(name = "plt_id", referencedColumnName = "plt_id", nullable = false)
    private Plant plant;

    public Story() {
    }

    public Story(int storyId, Plant plant, String pltName, LocalDateTime storyDate, String storyExplain, String storyMusic, String storyPoem, String storyCondition) {
        this.story_id = storyId;
//        this.user = user;
        this.plant = plant;
        this.story_date = storyDate;
        this.story_explain = storyExplain;
        this.story_music = storyMusic;
        this.story_poem = storyPoem;
        this.story_condition = storyCondition;
    }
}