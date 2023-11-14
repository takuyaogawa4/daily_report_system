package actions.views;



import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class FollowView {

        private Integer id;

        private Integer employee_id;

        private Integer followed_id;

        private LocalDateTime created_at;





    }


