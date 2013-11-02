package models.data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "game_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("fixed_time")
public class FixedTimeChallengeGame extends Game {

    private static final long serialVersionUID = 1L;

    
}
