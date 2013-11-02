package models.data;

import javax.persistence.*;
import play.data.validation.Constraints;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "game_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("lump_sump")

public class LumpSumGame extends Game {

    private static final long serialVersionUID = 1L;

    @Constraints.Required
    private Integer winningAmount;

    public Integer getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(Integer winningAmount) {
        this.winningAmount = winningAmount;
    }
}
