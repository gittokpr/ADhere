ALTER TABLE listing
ADD COLUMN IF NOT EXISTS rating numeric,
ADD COLUMN IF NOT EXISTS is_sponsored boolean;