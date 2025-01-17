package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import seedu.address.model.card.ExpiringCard;

/**
 * An UI component that displays information of a {@code ExpiringCard}.
 */
public class ExpiringCardCard extends CardCard {

    @FXML
    private VBox detailsContainer;

    public ExpiringCardCard(ExpiringCard card, int displayedIndex) {
        super(card, displayedIndex);
        this.detailsContainer.getChildren().add(
                new Label("Expires in " + Integer.toString(card.getMonthToExp())
                        + (card.getMonthToExp() == 1 ? " month" : " months")));
    }
}
