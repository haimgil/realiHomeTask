package com.reali.hometask.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing,Long> {
}
