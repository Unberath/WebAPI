select c1.concept_id as concept_id,  --all rows for all concepts, but you may split by conceptid
	c1.concept_name as concept_name,
	num.stratum_2 as x_calendar_month,   -- calendar year, note, there could be blanks
	1000*(1.0*num.count_value/denom.count_value) as y_prevalence_1000pp  --prevalence, per 1000 persons
from 
	(select * from @resultsSchema.dbo.heracles_results where analysis_id = 202 and cohort_definition_id in (@cohortDefinitionId)) num
	inner join
		(select * from @resultsSchema.dbo.heracles_results where analysis_id = 117 and cohort_definition_id in (@cohortDefinitionId)) denom on num.stratum_2 = denom.stratum_1  --calendar year
	inner join @cdmSchema.dbo.concept c1 on CAST(num.stratum_1 AS INT) = c1.concept_id
ORDER BY CAST(num.stratum_2 as INT)
