ALTER TABLE ${ohdsiSchema}.SOURCE_DAIMON
  ADD CONSTRAINT FK_source_daimon_source_id FOREIGN KEY (SOURCE_ID) REFERENCES ${ohdsiSchema}.SOURCE(SOURCE_ID);