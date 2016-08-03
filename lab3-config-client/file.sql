select id, estimation, created_at
from planning as pl
group by pl.id, max(pl.created_at);