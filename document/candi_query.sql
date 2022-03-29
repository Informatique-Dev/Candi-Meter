select TOPIC_LEVEL.describtion ,TOPIC_LEVEL.position_id,topic_question.describtion 
from candi_meter.TOPIC_LEVEL 
inner join candi_meter.topic_question
on TOPIC_LEVEL.topic_question_id =topic_question.id;

	-- 2
select topics.describtion ,topic_question.describtion  
from candi_meter.topics
inner join candi_meter.topic_question
on topics.topic_question_id =topic_question .id;

	-- 3
select topics.topic_name,topic_rate.rate 
from candi_meter.topics
inner join candi_meter.topic_rate 
on topics.id =topic_rate.topics_id ; 

	-- 4
select topics.topic_name,max(topic_rate.rate )
from candi_meter.topics
inner join candi_meter.topic_rate 
on topics.id =topic_rate.topics_id
group by topics.topic_name;

	--5
select *
from candi_meter.vacancy 
where expire_date >current_date 
group by id;


