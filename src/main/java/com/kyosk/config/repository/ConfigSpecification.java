package com.kyosk.config.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.kyosk.config.domain.Config;
import com.kyosk.config.service.dto.ConfigRequestDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

final class ConfigSpecification {

    private ConfigSpecification() {
    }

    static Specification<Config> getSpecifications(final ConfigRequestDto searchParams) {
        return (root, query, cb) -> {
            List<Predicate> predicates = getPredicates(searchParams, root, cb);
            query.distinct(true);
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    static List<Predicate> getPredicates(final ConfigRequestDto searchParams, final Root<Config> root, final CriteriaBuilder cb) {
        final List<Predicate> predicates = new ArrayList<>(1);

        Optional.ofNullable(searchParams.getName())
                .filter(StringUtils::isNotEmpty)
                .ifPresent(searchTerm -> {
                    Predicate orClause = cb.or(
                            cb.equal(root.get("name"), searchTerm));
                    predicates.add(orClause);
                });

            //todo Add predicate to get key value of metadata

        return predicates;
    }
}
