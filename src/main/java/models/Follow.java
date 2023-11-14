package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = JpaConst.TABLE_FOLLOW)
@NamedQueries({

        @NamedQuery(name = JpaConst.Q_FOLLOW_GET_BY_ID, query = JpaConst.Q_FOLLOW_GET_BY_ID_DEF),
        @NamedQuery(name = JpaConst.Q_UNFOLLOW_BY_ID, query = JpaConst.Q_UNFOLLOW_BY_ID_DEF)
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Follow {

    //id
    @Id
    @Column(name = JpaConst.EMP_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //管理者の社員番号

    @Column(name = JpaConst.FOLLOW_COL_EMP_ID, nullable = false)
    private  Integer employee_id;

    //フォローする社員番号

    @Column(name = JpaConst.FOLLOW_COL_FOLLOW_ID, nullable = false)
    private Integer followed_id;

    @Column(name =  JpaConst.FOLLOW_CREATED_AT,nullable = false)
    private LocalDateTime created_at;

}
