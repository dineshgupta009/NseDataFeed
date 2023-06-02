package com.NseDataFeed.Repository;

import com.NseDataFeed.Entity.OptionChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionChainRepository extends JpaRepository<OptionChain,Long> {
}
